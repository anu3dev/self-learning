const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { ModuleFederationPlugin } = require('webpack').container;

module.exports = (env = {}) => {
  const port = env.PORT || 3000;
  return {
    entry: path.resolve(__dirname, './src/index.js'),
    mode: 'development',
    devServer: {
      port,
      historyApiFallback: true
    },
    output: { publicPath: `http://localhost:${port}/` },
    module: {
      rules: [
        { test: /\.jsx?$/, loader: 'babel-loader', exclude: /node_modules/, options: { presets: ['@babel/preset-react'] } },
        { test: /\.css$/, use: ['style-loader', 'css-loader'] }
      ]
    },
    plugins: [
      new ModuleFederationPlugin({
        name: 'host',
        remotes: {
          productsApp: 'productsApp@http://localhost:3001/remoteEntry.js',
          cartApp: 'cartApp@http://localhost:3002/remoteEntry.js'
        },
        shared: {
          // singleton -> will handle access through main app
          // eager -> will handle access through stand alone as well
          react: { singleton: true, eager: true, requiredVersion: '^18.2.0' },
          // singleton -> will handle access through main app
          // eager -> will handle access through stand alone as well
          'react-dom': { singleton: true, eager: true, requiredVersion: '^18.2.0' }
        }
      }),
      new HtmlWebpackPlugin({ template: './public/index.html' })
    ],
    resolve: { extensions: ['.js', '.jsx'] }
  };
};
