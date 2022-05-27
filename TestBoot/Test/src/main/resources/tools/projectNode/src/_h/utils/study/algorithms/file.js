const fs = require('fs')

const createDirIfNotExists = (dir) => (!fs.existsSync(dir) ? fs.mkdirSync(dir) : undefined)

const readFileLines = (filename) => {
  fs.readFileSync(filename).toString('UTF8').split('\n')
}
