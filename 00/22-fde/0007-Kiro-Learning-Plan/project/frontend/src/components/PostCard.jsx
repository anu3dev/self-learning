import { Link } from 'react-router-dom';

function formatDate(str) {
  return new Date(str).toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' });
}

export default function PostCard({ post }) {
  return (
    <article className="card p-5 flex flex-col gap-3 hover:shadow-md transition-shadow">
      {post.cover_url && (
        <img
          src={post.cover_url}
          alt={post.title}
          className="w-full h-44 object-cover rounded-lg"
        />
      )}

      <div className="flex items-center gap-2 text-xs text-gray-500">
        <img
          src={post.author_avatar || `https://ui-avatars.com/api/?name=${post.author_username}&size=24`}
          alt={post.author_username}
          className="w-6 h-6 rounded-full"
        />
        <Link to={`/author/${post.author_username}`} className="font-medium text-gray-700 hover:text-indigo-600 no-underline">
          {post.author_username}
        </Link>
        <span>·</span>
        <time>{formatDate(post.created_at)}</time>
      </div>

      <div>
        <Link to={`/post/${post.slug}`} className="no-underline">
          <h2 className="text-lg font-semibold text-gray-900 hover:text-indigo-600 leading-snug line-clamp-2">
            {post.title}
          </h2>
        </Link>
        {post.excerpt && (
          <p className="mt-1 text-sm text-gray-500 line-clamp-2">{post.excerpt}</p>
        )}
      </div>

      <div className="flex items-center justify-between mt-auto">
        <div className="flex gap-2 flex-wrap">
          {post.tags?.slice(0, 3).map((tag) => (
            <Link
              key={tag}
              to={`/?tag=${tag}`}
              className="text-xs bg-indigo-50 text-indigo-600 px-2 py-0.5 rounded-full no-underline hover:bg-indigo-100"
            >
              #{tag}
            </Link>
          ))}
        </div>
        <div className="flex items-center gap-3 text-xs text-gray-400">
          <span>❤ {post.like_count}</span>
          <span>💬 {post.comment_count}</span>
        </div>
      </div>
    </article>
  );
}
