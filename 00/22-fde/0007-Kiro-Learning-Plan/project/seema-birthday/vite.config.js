import react from '@vitejs/plugin-react'
import { defineConfig } from 'vite'

export default defineConfig({
  plugins: [react()],
  build: {
    // raise the warning threshold so large photos don't cause noisy warnings
    chunkSizeWarningLimit: 2000,
    assetsInlineLimit: 0, // never inline images — keep them as separate files
    rollupOptions: {
      output: {
        // separate image assets into their own directory for clarity
        assetFileNames: (assetInfo) => {
          const ext = assetInfo.name?.split('.').pop()?.toLowerCase();
          if (['jpg','jpeg','png','webp','gif'].includes(ext || '')) {
            return 'assets/images/[name]-[hash][extname]';
          }
          return 'assets/[name]-[hash][extname]';
        },
      },
    },
  },
})
