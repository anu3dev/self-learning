import { useNavigate } from 'react-router-dom';
import { createPost } from '../api/posts';
import PostEditor from '../components/PostEditor';
import toast from 'react-hot-toast';

export default function NewPostPage() {
  const navigate = useNavigate();

  const handleSubmit = async (data) => {
    try {
      const post = await createPost(data);
      toast.success('Post created!');
      navigate(`/post/${post.slug}`);
    } catch (err) {
      toast.error(err.message);
    }
  };

  return (
    <div className="max-w-3xl mx-auto px-4 py-10">
      <h1 className="text-2xl font-bold text-gray-900 mb-6">New post</h1>
      <PostEditor onSubmit={handleSubmit} submitLabel="Publish post" />
    </div>
  );
}
