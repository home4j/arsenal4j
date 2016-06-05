const webpack = require('webpack');
const path = require('path');
const buildPath = path.resolve(__dirname, 'build');
const srcPath = path.resolve(__dirname, 'src/demo');
const nodeModulesPath = path.resolve(__dirname, 'node_modules');
const TransferWebpackPlugin = require('transfer-webpack-plugin');

const config = {
    // Entry points to the project
    entry: {
        app: [
            'webpack/hot/dev-server',
            'webpack/hot/only-dev-server',
            srcPath + '/app/app.js'
        ], hello: [
            'webpack/hot/dev-server',
            'webpack/hot/only-dev-server',
            srcPath + '/hello/hello.js'
        ], bar: [
            'webpack/hot/dev-server',
            'webpack/hot/only-dev-server',
            srcPath + '/bar/bar.js'
        ], stepper: [
            'webpack/hot/dev-server',
            'webpack/hot/only-dev-server',
            srcPath + '/stepper/stepper.js'
        ]
    },
    output: {
        path: buildPath, // Path of output file
        filename: '[name].bundle.js',
    },
    externals: [
        // 想使用externals来分割依赖库和业务代码，但最终都已莫名的失败告终，需向人请教
        // {
        //     'react': 'React',
        //     'react-dom': 'ReactDOM'
        // },
        // /^react\/lib\// // 不清楚react.js本身及其目录下的lib有什么关联，是否前者包含后者
    ],
    // Server Configuration options
    devServer: {
        contentBase: 'src', // Relative directory for base of server
        devtool: 'eval',
        hot: true, // Live-reload
        inline: true,
        port: 3000, // Port Number
        // host: 'localhost' // Change to '0.0.0.0' for external facing server
        host: '0.0.0.0'
    },
    devtool: 'eval',
    plugins: [
        // Enables Hot Modules Replacement
        new webpack.HotModuleReplacementPlugin(),
        // Allows error warnings but does not stop compiling.
        new webpack.NoErrorsPlugin(),
        // Moves files
        new TransferWebpackPlugin([
            {from: 'demo'},
        ], path.resolve(__dirname, 'src')),
    ],
    module: {
        loaders: [
            {
                // React-hot loader and
                test: /\.js$/, // All .js files
                loaders: ['babel-loader'],
                // loaders: ['react-hot', 'babel-loader'], // react-hot is like browser sync and babel loads jsx and es6-7
                exclude: [nodeModulesPath],
            },
        ],
    },
};

module.exports = config;
