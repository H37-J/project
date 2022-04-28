const path = require('path');
const webpack = require('webpack')
module.exports = {
  mode: 'development',

  entry: {
    app: ['@babel/polyfill','./src/axios.js'],
  },

  output: {
    filename: 'axios.js',
    path: path.join(__dirname,'dist'),
  },

 

  module : {
    rules:[{
      test: /\.(js|jsx)$/,
      use:'babel-loader',
    }],

    rules:[{
      test: /\.jsx?/,
      loader:'babel-loader',
      options : {
        presets : ['@babel/preset-env','@babel/preset-react'],
      }
    }]
  },

  resolve: {
    modules: ['node_modules'],
    fallback: {
      "fs": false,
      "crypto":false,
      "child_process": false,
      "crypto-browserify": require.resolve('crypto-browserify')
    }
  },

  plugins: [
    new webpack.ProvidePlugin({
      process: 'process/browser',
    }),
  ],




};