import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import federation from "@originjs/vite-plugin-federation";

export default defineConfig({
  plugins: [
    react(),
    federation({
      name: "host",
      remotes: {
        // IMPORTANT → the federation plugin outputs remoteEntry.js inside /assets/
        productsApp: "http://localhost:3001/assets/remoteEntry.js",
        cartApp: "http://localhost:3002/assets/remoteEntry.js"
      },
      shared: ["react", "react-dom"]
    })
  ],
  build: {target: "esnext"}
});
