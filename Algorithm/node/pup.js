const puppeteer = require('puppeteer');

// (async () => {
//   const browser = await puppeteer.launch();
//   const page = await browser.newPage();
//   await page.goto('https://www.youtube.com/');
//   await page.screenshot({ path: 'youtube.png' });

//   await browser.close();
// })();

(async () => {
const browser = await puppeteer.launch(); 
const page = await browser.newPage(); 
await page.goto('https://youtube.com'); 
await page.waitForSelector('input[id="search"]'); 
await setCookies(page); 
const input = 'test'
await page.$('input[id="search"]'); 
await input.click(); // Search 창에 입력 
await input.type(keyword); // 엔터 키 누름 
await page.keyboard.press('Enter'); 
await page.waitForSelector('ytd-video-renderer,ytd-grid-video-renderer'); 
const html = await page.content(); 
console.log(html)
browser.close();

})