
import { Vimeo } from 'vimeo';
import express from 'express'
const app = express();
const port = 3000;

app.get('/', (req, res) => {
    VimeoAPI(function(data) {
        return res.send(data);
    })
});



function VimeoAPI(fn) {
    const client_id = '0eb8b3c504ba3cb0f39ba450d4ceb0da906a0308'
    const client_secret = 'jfuJK/G3TlxF1vhnUV2jJTpP/o35g7+Xe+03mYVabnQSeROHpSoHarB95hifAT/A+E+7UuLOBGzItwJOKUeBde3d6iSwuTezQ774bOzKloqEgNuoT5ws01a4Is2i66Rq'
    const token = '2dec94023da5a6cd014e1fbde4790630'
    let client = new Vimeo(client_id, client_secret, token);

    client.request({
        method: 'GET',
        path: '/me/videos'
    }, function (error, data, status_code, headers) {
        if (error) {
            console.log(error);
        }

        console.log(data)

        return fn(data)

    })
}




app.listen(port, () => {
    console.log('Express listening on port', port);
});
