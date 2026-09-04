import { useEffect, useState, useCallback } from 'react';
import { useSearchParams } from 'react-router-dom';
import { getPosts } from '../api/posts';
import PostCard from '../components/PostCard';
import TagsSidebar from '../components/TagsSidebar';
import Spinner from '../components/Spinner';

export default function HomePage() {
  const [searchParams, setSearchParams] = useSearchParams();
  const tag    = searchParams.get('tag')    || '';
  const author = searchParams.get('author') || '';
  const search = searchParams.get('search') || '';
  const page   = Number(searchParams.get('page') || 1);

  const [posts, setPosts]           = useState([]);
  const [pagination, setPagination] = useState(null);
  const [loading, setLoading]       = useState(true);
  const [query, setQuery]           = useState(search);

  const load = useCallback(async () => {
    setLoading(true);
    try {
      const data = await getPosts({ tag, author, search, page });
      setPosts(data.posts);
      setPagination(data.pagination);
    } catch {
      setPosts([]);
    } finally {
      setLoading(false);
    }
  }, [tag, author, search, page]);

  useEffect(() => { load(); }, [load]);

  const handleSearch = (e) => {
    e.preventDefault();
    const p = new URLSearchParams(searchParams);
    if (query) p.set('search', query); else p.delete('search');
    p.delete('page');
    setSearchParams(p);
  };

  return (
    <div className="max-w-5xl mx-auto px-4 py-8">
      {/* Search bar */}
      <form onSubmit={handleSearch} className="mb-6 flex gap-2">
        <input
          className="input flex-1"
          placeholder="Search posts…"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
        />
        <button type="submit" className="btn-primary">Search</button>
        {search && (
          <button
            type="button"
            className="btn-secondary"
            onClick={() => { setQuery(''); setSearchParams({}); }}
          >
            Clear
          </button>
        )}
      </form>

      <div className="flex gap-6">
        {/* Post list */}
        <main className="flex-1 min-w-0">
          {tag && (
            <p className="mb-4 text-sm text-gray-500">
              Showing posts tagged <span className="font-semibold text-indigo-600">#{tag}</span>
            </p>
          )}
          {author && (
            <p className="mb-4 text-sm text-gray-500">
              Posts by <span className="font-semibold text-indigo-600">@{author}</span>
            </p>
          )}

          {loading ? (
            <div className="flex justify-center py-20"><Spinner size="lg" /></div>
          ) : posts.length === 0 ? (
            <div className="text-center py-20 text-gray-400">No posts found.</div>
          ) : (
            <div className="grid gap-5">
              {posts.map((p) => <PostCard key={p.id} post={p} />)}
            </div>
          )}

          {/* Pagination */}
          {pagination && pagination.pages > 1 && (
            <div className="mt-8 flex justify-center gap-2">
              {Array.from({ length: pagination.pages }, (_, i) => i + 1).map((p) => {
                const sp = new URLSearchParams(searchParams);
                sp.set('page', p);
                return (
                  <button
                    key={p}
                    onClick={() => setSearchParams(sp)}
                    className={`px-3 py-1.5 rounded-lg text-sm font-medium transition-colors ${
                      p === page
                        ? 'bg-indigo-600 text-white'
                        : 'bg-white border border-gray-300 text-gray-700 hover:bg-gray-50'
                    }`}
                  >
                    {p}
                  </button>
                );
              })}
            </div>
          )}
        </main>

        {/* Sidebar */}
        <aside className="hidden lg:block w-56 shrink-0">
          <TagsSidebar />
        </aside>
      </div>
    </div>
  );
}
