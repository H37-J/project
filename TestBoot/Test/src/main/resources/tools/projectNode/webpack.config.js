const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const path = require('path');
module.exports = {

    entry: './src/index.jsx',
    mode: 'development',
    stats: { warnings: false },
    output: {
        path: __dirname + '/dist',
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.tsx', '.ts', '.js', '.jsx'],
        alias: {
            process: 'process/browser',
            '@': path.resolve(__dirname, 'src'),
        },
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: '[name].css',
        }),
    ],
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader'
                }
            },
            {
                test: /\.(ts|tsx)$/,
                exclude: /node_modules/,
                use: 'ts-loader',
            },
            {
                test: /\.(sa|sc|c)ss$/i,
                use: ["style-loader", "css-loader", "sass-loader"],
            },
        ]
    },
};


