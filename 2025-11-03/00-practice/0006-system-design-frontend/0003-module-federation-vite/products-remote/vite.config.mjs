import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import federation from '@originjs/vite-plugin-federation';

export default defineConfig({
  plugins: [
    federation({
      name: 'productsApp',
      filename: 'remoteEntry.js',
      exposes: {
        './ProductList': './src/ProductList.jsx'
      },
      shared: ['react', 'react-dom']
    }),
    react()
  ],
  build: { target: 'esnext' }
});
