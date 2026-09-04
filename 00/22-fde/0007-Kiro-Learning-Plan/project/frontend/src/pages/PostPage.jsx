import { useEffect, useState, useCallback } from 'react';
import { useParams, Link, useNavigate } from 'react-router-dom';
import { getPost, getComments, toggleLike, deletePost } from '../api/posts';
import { useAuth } from '../context/AuthContext';
import CommentSection from '../components/CommentSection';
import Spinner from '../components/Spinner';
import toast from 'react-hot-toast';

function formatDate(str) {
  return new Date(str).toLocaleDateString('en-US', { month: 'long', day: 'numeric', year: 'numeric' });
}

export default function PostPage() {
  const { slug }   = useParams();
  const { user }   = useAuth();
  const navigate   = useNavigate();

  const [post, setPost]         = useState(null);
  const [comments, setComments] = useState([]);
  const [loading, setLoading]   = useState(true);
  const [liking, setLiking]     = useState(false);

  const loadPost = useCallback(async () => {
    try {
      const p = await getPost(slug);
      setPost(p);
    } catch {
      setPost(null);
    } finally {
      setLoading(false);
    }
  }, [slug]);

  const loadComments = useCallback(async () => {
    try {
      const c = await getComments(slug);
      setComments(c);
    } catch {
      setComments([]);
    }
  }, [slug]);

  useEffect(() => { loadPost(); loadComments(); }, [loadPost, loadComments]);

  const handleLike = async () => {
    if (!user) { toast.error('Please log in to like posts'); return; }
    setLiking(true);
    try {
      const res = await toggleLike(slug);
      setPost((p) => ({ ...p, liked: res.liked, like_count: res.like_count }));
    } catch (err) {
      toast.error(err.message);
    } finally {
      setLiking(false);
    }
  };

  const handleDelete = async () => {
    if (!confirm('Delete this post permanently?')) return;
    try {
      await deletePost(slug);
      toast.success('Post deleted');
      navigate('/dashboard');
    } catch (err) {
      toast.error(err.message);
    }
  };

  if (loading) return <div className="flex justify-center py-32"><Spinner size="lg" /></div>;
  if (!post) return <div className="text-center py-32 text-gray-400">Post not found.</div>;

  const isAuthor = user?.id === post.author_id;

  return (
    <div className="max-w-3xl mx-auto px-4 py-10">
      {post.cover_url && (
        <img src={post.cover_url} alt={post.title} className="w-full h-64 object-cover rounded-xl mb-8" />
      )}

      {/* Tags */}
      <div className="flex gap-2 flex-wrap mb-4">
        {post.tags?.map((t) => (
          <Link key={t} to={`/?tag=${t}`} className="text-xs bg-indigo-50 text-indigo-600 px-2 py-0.5 rounded-full no-underline hover:bg-indigo-100">
            #{t}
          </Link>
        ))}
      </div>

      <h1 className="text-3xl font-bold text-gray-900 leading-tight mb-4">{post.title}</h1>

      {/* Author & meta */}
      <div className="flex items-center justify-between mb-8">
        <div className="flex items-center gap-3">
          <img
            src={post.author_avatar || `https://ui-avatars.com/api/?name=${post.author_username}&size=40`}
            alt={post.author_username}
            className="w-10 h-10 rounded-full"
          />
          <div>
            <Link to={`/author/${post.author_username}`} className="font-medium text-gray-800 hover:text-indigo-600 no-underline">
              {post.author_username}
            </Link>
            <p className="text-xs text-gray-400">{formatDate(post.created_at)}</p>
          </div>
        </div>

        {isAuthor && (
          <div className="flex gap-2">
            <Link to={`/edit/${post.slug}`} className="btn-secondary text-sm no-underline">Edit</Link>
            <button onClick={handleDelete} className="btn-danger text-sm">Delete</button>
          </div>
        )}
      </div>

      {/* Content */}
      <div className="prose prose-gray max-w-none mb-10 whitespace-pre-wrap text-gray-800 leading-relaxed">
        {post.content}
      </div>

      {/* Like button */}
      <div className="flex items-center gap-2 mb-10">
        <button
          onClick={handleLike}
          disabled={liking}
          aria-pressed={post.liked}
          className={`flex items-center gap-1.5 px-4 py-2 rounded-full text-sm font-medium border transition-colors ${
            post.liked
              ? 'bg-red-50 text-red-600 border-red-200 hover:bg-red-100'
              : 'bg-white text-gray-600 border-gray-200 hover:bg-gray-50'
          }`}
        >
          {post.liked ? '❤' : '🤍'} {post.like_count} {post.like_count === 1 ? 'like' : 'likes'}
        </button>
      </div>

      <hr className="border-gray-200 mb-8" />

      <CommentSection slug={slug} comments={comments} onRefresh={loadComments} />
    </div>
  );
}
