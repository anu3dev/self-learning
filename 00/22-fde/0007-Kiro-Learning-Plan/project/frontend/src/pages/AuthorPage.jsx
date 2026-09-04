import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getPosts } from '../api/posts';
import PostCard from '../components/PostCard';
import Spinner from '../components/Spinner';

export default function AuthorPage() {
  const { username } = useParams();
  const [posts, setPosts]   = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    getPosts({ author: username, limit: 50 })
      .then((d) => setPosts(d.posts))
      .catch(() => setPosts([]))
      .finally(() => setLoading(false));
  }, [username]);

  return (
    <div className="max-w-4xl mx-auto px-4 py-10">
      <div className="flex items-center gap-4 mb-8">
        <img
          src={`https://ui-avatars.com/api/?name=${username}&size=64`}
          alt={username}
          className="w-16 h-16 rounded-full"
        />
        <div>
          <h1 className="text-2xl font-bold text-gray-900">@{username}</h1>
          <p className="text-sm text-gray-500">{posts.length} published post{posts.length !== 1 ? 's' : ''}</p>
        </div>
      </div>

      {loading ? (
        <div className="flex justify-center py-20"><Spinner size="lg" /></div>
      ) : posts.length === 0 ? (
        <p className="text-center text-gray-400 py-20">No posts yet.</p>
      ) : (
        <div className="grid gap-5 sm:grid-cols-2">
          {posts.map((p) => <PostCard key={p.id} post={p} />)}
        </div>
      )}
    </div>
  );
}
