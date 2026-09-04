import { useState } from 'react';
import { useAuth } from '../context/AuthContext';
import { updateMe } from '../api/auth';
import toast from 'react-hot-toast';

export default function ProfilePage() {
  const { user, setUser } = useAuth();
  const [form, setForm] = useState({ bio: user?.bio || '', avatar_url: user?.avatar_url || '' });
  const [saving, setSaving] = useState(false);

  const set = (k) => (e) => setForm((f) => ({ ...f, [k]: e.target.value }));

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    try {
      const updated = await updateMe(form);
      setUser(updated);
      toast.success('Profile updated!');
    } catch (err) {
      toast.error(err.message);
    } finally {
      setSaving(false);
    }
  };

  return (
    <div className="max-w-xl mx-auto px-4 py-10">
      <h1 className="text-2xl font-bold text-gray-900 mb-2">Profile</h1>
      <p className="text-sm text-gray-500 mb-6">@{user?.username} · {user?.email}</p>

      <div className="card p-6">
        <div className="flex items-center gap-4 mb-6">
          <img
            src={form.avatar_url || `https://ui-avatars.com/api/?name=${user?.username}&size=64`}
            alt={user?.username}
            className="w-16 h-16 rounded-full object-cover border border-gray-200"
          />
          <div>
            <p className="font-semibold text-gray-800">{user?.username}</p>
            <p className="text-sm text-gray-400">{user?.email}</p>
          </div>
        </div>

        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1" htmlFor="avatar_url">Avatar URL</label>
            <input id="avatar_url" className="input" value={form.avatar_url} onChange={set('avatar_url')} placeholder="https://…" />
          </div>
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1" htmlFor="bio">Bio</label>
            <textarea id="bio" className="input resize-none" rows={3} value={form.bio} onChange={set('bio')} placeholder="Tell the world about yourself…" />
          </div>
          <div className="flex justify-end">
            <button type="submit" disabled={saving} className="btn-primary">
              {saving ? 'Saving…' : 'Save changes'}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
