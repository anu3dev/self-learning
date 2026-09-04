import { Link, NavLink, useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

export default function Navbar() {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/');
  };

  return (
    <header className="sticky top-0 z-50 bg-white border-b border-gray-200 shadow-sm">
      <div className="max-w-5xl mx-auto px-4 h-14 flex items-center justify-between">
        <Link to="/" className="text-xl font-bold text-indigo-600 no-underline">
          ✍ BlogSpace
        </Link>

        <nav className="flex items-center gap-4 text-sm font-medium">
          <NavLink to="/" end className={({ isActive }) => isActive ? 'text-indigo-600' : 'text-gray-600 hover:text-gray-900'}>
            Home
          </NavLink>

          {user ? (
            <>
              <NavLink to="/new" className={({ isActive }) => isActive ? 'text-indigo-600' : 'text-gray-600 hover:text-gray-900'}>
                Write
              </NavLink>
              <NavLink to="/dashboard" className={({ isActive }) => isActive ? 'text-indigo-600' : 'text-gray-600 hover:text-gray-900'}>
                Dashboard
              </NavLink>
              <NavLink to="/profile" className={({ isActive }) => isActive ? 'text-indigo-600' : 'text-gray-600 hover:text-gray-900'}>
                {user.username}
              </NavLink>
              <button onClick={handleLogout} className="text-gray-500 hover:text-red-600 transition-colors">
                Logout
              </button>
            </>
          ) : (
            <>
              <Link to="/login" className="text-gray-600 hover:text-gray-900 no-underline">Login</Link>
              <Link to="/register" className="btn-primary text-sm px-3 py-1.5 no-underline">Sign up</Link>
            </>
          )}
        </nav>
      </div>
    </header>
  );
}
