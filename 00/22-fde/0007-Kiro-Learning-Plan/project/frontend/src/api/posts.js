import client from './client';

export const getPosts      = (params) => client.get('/posts', { params });
export const getPost       = (slug)   => client.get(`/posts/${slug}`);
export const createPost    = (data)   => client.post('/posts', data);
export const updatePost    = (slug, data) => client.patch(`/posts/${slug}`, data);
export const deletePost    = (slug)   => client.delete(`/posts/${slug}`);
export const toggleLike    = (slug)   => client.post(`/posts/${slug}/like`);

export const getComments   = (slug)   => client.get(`/posts/${slug}/comments`);
export const createComment = (slug, data) => client.post(`/posts/${slug}/comments`, data);
export const deleteComment = (slug, id)   => client.delete(`/posts/${slug}/comments/${id}`);

export const getTags       = ()       => client.get('/tags');
