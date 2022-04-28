import express from 'express';
import WebpackDevServer from 'webpack-dev-server';
import webpack from 'webpack';
import posts from './routes/posts';
import counter from './routes/counter';

const app = express();
const port = 3000;
const devPort = 4000;

if (process.env.NODE_ENV == 'development') {
    console.log('Server is running on development mode');

    const config = require('../webpack.dev.config');
    let compiler = webpack(config);
    let devServer = new WebpackDevServer(compiler, config.devServer);
    devServer.listen(devPort, () => {
        console.log('webpack-dev-server is listening on port', devPort);
    });
}

let data = { number: 0 };

app.use('/', express.static(__dirname + '/../public'));
app.use('/posts', posts);
app.use('/counter', counter(data));

app.get('/hello', (req, res) => {
    return res.send('Can you hear me?');
});

app.get('/user', function (req, res) {
    con.query("SELECT * FROM USER", (err, results) => {
        if (err) throw error;
        res.send(results);
    });
});


const server = app.listen(port, () => {
    console.log('Express listening on port', port);
});
