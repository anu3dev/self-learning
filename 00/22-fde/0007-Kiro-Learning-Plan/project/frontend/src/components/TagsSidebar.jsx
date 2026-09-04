import { useEffect, useState } from 'react';
import { Link, useSearchParams } from 'react-router-dom';
import { getTags } from '../api/posts';

export default function TagsSidebar() {
  const [tags, setTags] = useState([]);
  const [params] = useSearchParams();
  const active = params.get('tag');

  useEffect(() => {
    getTags().then(setTags).catch(() => {});
  }, []);

  if (!tags.length) return null;

  return (
    <aside className="card p-4">
      <h3 className="text-sm font-semibold text-gray-700 mb-3">Popular Tags</h3>
      <div className="flex flex-wrap gap-2">
        {active && (
          <Link
            to="/"
            className="text-xs px-3 py-1 rounded-full bg-gray-200 text-gray-600 hover:bg-gray-300 no-underline"
          >
            ✕ Clear
          </Link>
        )}
        {tags.map((t) => (
          <Link
            key={t.name}
            to={`/?tag=${t.name}`}
            className={`text-xs px-3 py-1 rounded-full no-underline transition-colors ${
              active === t.name
                ? 'bg-indigo-600 text-white'
                : 'bg-indigo-50 text-indigo-600 hover:bg-indigo-100'
            }`}
          >
            #{t.name}
            <span className="ml-1 text-indigo-400">({t.post_count})</span>
          </Link>
        ))}
      </div>
    </aside>
  );
}
