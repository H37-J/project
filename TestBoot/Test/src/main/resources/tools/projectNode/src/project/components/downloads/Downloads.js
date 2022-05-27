import React from "react";
import JSZipUtils from "jszip-utils";
import JSZip from "jszip";
import { saveAs } from "file-saver";

const Downloads = () => {
  let zip = new JSZip();
  let count = 0;
  let zipFilename = "test.zip";

  let urls = [
    "https://kua.bigdeo.com/wp-content/uploads/assignments/assignment_16211_164733681150_2061008_.hwp",
  ];

  let donwloadAll = () =>
    urls.forEach(function (url, index) {
      let filename =  index + ".hwp";
      JSZipUtils.getBinaryContent(url, async function (err, data) {
        if (err) {
          throw err;
        }
        zip.file(filename, data, { binary: true });
        count++;
        if (count == urls.length) {
          let zipFile = await zip.generateAsync({ type: "blob" });
          saveAs(zipFile, zipFilename);
        }
      });
    });
  return <button onClick={donwloadAll}>다운로드</button>;
};

export default Downloads;
