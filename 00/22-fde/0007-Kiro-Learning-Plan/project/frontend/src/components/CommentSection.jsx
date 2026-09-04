import { useState } from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { createComment, deleteComment } from '../api/posts';
import toast from 'react-hot-toast';

function formatDate(str) {
  return new Date(str).toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' });
}

export default function CommentSection({ slug, comments, onRefresh }) {
  const { user } = useAuth();
  const [body, setBody] = useState('');
  const [submitting, setSubmitting] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!body.trim()) return;
    setSubmitting(true);
    try {
      await createComment(slug, { body });
      setBody('');
      onRefresh();
    } catch (err) {
      toast.error(err.message);
    } finally {
      setSubmitting(false);
    }
  };

  const handleDelete = async (id) => {
    if (!confirm('Delete this comment?')) return;
    try {
      await deleteComment(slug, id);
      onRefresh();
    } catch (err) {
      toast.error(err.message);
    }
  };

  return (
    <section aria-label="Comments">
      <h2 className="text-xl font-semibold text-gray-800 mb-4">
        Comments ({comments.length})
      </h2>

      {user ? (
        <form onSubmit={handleSubmit} className="mb-6">
          <textarea
            value={body}
            onChange={(e) => setBody(e.target.value)}
            placeholder="Share your thoughts…"
            rows={3}
            className="input resize-none"
            required
          />
          <div className="mt-2 flex justify-end">
            <button type="submit" disabled={submitting} className="btn-primary">
              {submitting ? 'Posting…' : 'Post comment'}
            </button>
          </div>
        </form>
      ) : (
        <p className="text-sm text-gray-500 mb-6">
          <Link to="/login">Log in</Link> to leave a comment.
        </p>
      )}

      <ul className="space-y-4">
        {comments.map((c) => (
          <li key={c.id} className="card p-4">
            <div className="flex items-center justify-between mb-2">
              <div className="flex items-center gap-2">
                <img
                  src={c.author_avatar || `https://ui-avatars.com/api/?name=${c.author_username}&size=28`}
                  alt={c.author_username}
                  className="w-7 h-7 rounded-full"
                />
                <span className="font-medium text-sm text-gray-800">{c.author_username}</span>
                <span className="text-xs text-gray-400">{formatDate(c.created_at)}</span>
              </div>
              {user?.id === c.author_id && (
                <button
                  onClick={() => handleDelete(c.id)}
                  className="text-xs text-red-500 hover:text-red-700"
                  aria-label="Delete comment"
                >
                  Delete
                </button>
              )}
            </div>
            <p className="text-sm text-gray-700 whitespace-pre-wrap">{c.body}</p>
          </li>
        ))}
      </ul>
    </section>
  );
}
