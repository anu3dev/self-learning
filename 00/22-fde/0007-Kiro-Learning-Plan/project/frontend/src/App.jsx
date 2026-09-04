import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { Toaster } from 'react-hot-toast';
import { AuthProvider, useAuth } from './context/AuthContext';
import Navbar from './components/Navbar';
import Spinner from './components/Spinner';

import HomePage     from './pages/HomePage';
import PostPage     from './pages/PostPage';
import LoginPage    from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import NewPostPage  from './pages/NewPostPage';
import EditPostPage from './pages/EditPostPage';
import DashboardPage from './pages/DashboardPage';
import ProfilePage  from './pages/ProfilePage';
import AuthorPage   from './pages/AuthorPage';

function ProtectedRoute({ children }) {
  const { user, loading } = useAuth();
  if (loading) return <div className="flex justify-center py-32"><Spinner size="lg" /></div>;
  if (!user)   return <Navigate to="/login" replace />;
  return children;
}

function AppRoutes() {
  return (
    <div className="min-h-screen flex flex-col">
      <Navbar />
      <div className="flex-1">
        <Routes>
          <Route path="/"               element={<HomePage />} />
          <Route path="/post/:slug"     element={<PostPage />} />
          <Route path="/author/:username" element={<AuthorPage />} />
          <Route path="/login"          element={<LoginPage />} />
          <Route path="/register"       element={<RegisterPage />} />

          <Route path="/new"       element={<ProtectedRoute><NewPostPage /></ProtectedRoute>} />
          <Route path="/edit/:slug" element={<ProtectedRoute><EditPostPage /></ProtectedRoute>} />
          <Route path="/dashboard" element={<ProtectedRoute><DashboardPage /></ProtectedRoute>} />
          <Route path="/profile"   element={<ProtectedRoute><ProfilePage /></ProtectedRoute>} />

          <Route path="*" element={<div className="text-center py-32 text-gray-400 text-xl">404 — Page not found</div>} />
        </Routes>
      </div>
      <footer className="border-t border-gray-200 text-center text-xs text-gray-400 py-4">
        © {new Date().getFullYear()} BlogSpace
      </footer>
    </div>
  );
}

export default function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Toaster position="top-right" toastOptions={{ duration: 3000 }} />
        <AppRoutes />
      </AuthProvider>
    </BrowserRouter>
  );
}
