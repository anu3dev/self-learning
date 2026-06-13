import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import federation from '@originjs/vite-plugin-federation';

export default defineConfig({
  plugins: [
    federation({
      name: 'cartApp',
      filename: 'remoteEntry.js',
      exposes: {
        './CartWidget': './src/CartWidget.jsx'
      },
      shared: ['react', 'react-dom']
    }),
    react()
  ],
  build: { target: 'esnext' }
});
