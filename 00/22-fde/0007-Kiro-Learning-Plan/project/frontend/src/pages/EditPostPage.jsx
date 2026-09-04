import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { getPost, updatePost } from '../api/posts';
import { useAuth } from '../context/AuthContext';
import PostEditor from '../components/PostEditor';
import Spinner from '../components/Spinner';
import toast from 'react-hot-toast';

export default function EditPostPage() {
  const { slug }  = useParams();
  const { user }  = useAuth();
  const navigate  = useNavigate();
  const [post, setPost]     = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getPost(slug)
      .then((p) => {
        if (p.author_id !== user?.id) {
          toast.error('Not authorized');
          navigate('/');
          return;
        }
        setPost(p);
      })
      .catch(() => { toast.error('Post not found'); navigate('/'); })
      .finally(() => setLoading(false));
  }, [slug, user, navigate]);

  const handleSubmit = async (data) => {
    try {
      const updated = await updatePost(slug, data);
      toast.success('Post updated!');
      navigate(`/post/${updated.slug}`);
    } catch (err) {
      toast.error(err.message);
    }
  };

  if (loading) return <div className="flex justify-center py-32"><Spinner size="lg" /></div>;

  return (
    <div className="max-w-3xl mx-auto px-4 py-10">
      <h1 className="text-2xl font-bold text-gray-900 mb-6">Edit post</h1>
      <PostEditor initial={post} onSubmit={handleSubmit} submitLabel="Save changes" />
    </div>
  );
}
