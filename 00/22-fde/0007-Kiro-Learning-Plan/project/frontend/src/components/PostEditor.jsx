import { useState } from 'react';

export default function PostEditor({ initial = {}, onSubmit, submitLabel = 'Publish' }) {
  const [form, setForm] = useState({
    title:     initial.title     || '',
    excerpt:   initial.excerpt   || '',
    content:   initial.content   || '',
    cover_url: initial.cover_url || '',
    tags:      initial.tags?.join(', ') || '',
    published: initial.published ?? true,
  });
  const [saving, setSaving] = useState(false);

  const set = (key) => (e) => setForm((f) => ({ ...f, [key]: e.target.value }));
  const toggle = (key) => () => setForm((f) => ({ ...f, [key]: !f[key] }));

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    try {
      const payload = {
        ...form,
        tags: form.tags.split(',').map((t) => t.trim()).filter(Boolean),
      };
      await onSubmit(payload);
    } finally {
      setSaving(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-5">
      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1" htmlFor="title">Title *</label>
        <input id="title" className="input" value={form.title} onChange={set('title')} required placeholder="Your post title" />
      </div>

      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1" htmlFor="excerpt">Excerpt</label>
        <input id="excerpt" className="input" value={form.excerpt} onChange={set('excerpt')} placeholder="Short summary shown on cards" />
      </div>

      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1" htmlFor="cover_url">Cover image URL</label>
        <input id="cover_url" className="input" value={form.cover_url} onChange={set('cover_url')} placeholder="https://…" />
      </div>

      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1" htmlFor="tags">Tags (comma separated)</label>
        <input id="tags" className="input" value={form.tags} onChange={set('tags')} placeholder="react, webdev, tutorial" />
      </div>

      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1" htmlFor="content">Content *</label>
        <textarea
          id="content"
          className="input font-mono text-sm resize-y"
          rows={16}
          value={form.content}
          onChange={set('content')}
          required
          placeholder="Write your post here…"
        />
      </div>

      <div className="flex items-center gap-3">
        <input
          id="published"
          type="checkbox"
          className="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
          checked={form.published}
          onChange={toggle('published')}
        />
        <label htmlFor="published" className="text-sm text-gray-700">Publish immediately</label>
      </div>

      <div className="flex justify-end">
        <button type="submit" disabled={saving} className="btn-primary">
          {saving ? 'Saving…' : submitLabel}
        </button>
      </div>
    </form>
  );
}
