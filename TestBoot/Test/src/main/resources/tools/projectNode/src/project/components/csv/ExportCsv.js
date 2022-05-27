import React, { useEffect } from "react";
import FileSaver from "file-saver";
import XLSX from "xlsx";

const ExportCSV = ({ csvData, fileName }) => {
  const fileType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8";
  const fileExtension = ".xlsx";

  const obj = {}
  const arr = Object.keys(csvData[0]);

  for (let i = 0; i < arr.length; i++) {
    obj[arr[i]] = arr[i];
  }

  const header = [obj]

  const exportToCSV = (csvData, fileName) => {
    const ws = XLSX.utils.json_to_sheet(header, {
      header: [],
      skipHeader: true,
      origin: 0
    });

    XLSX.utils.sheet_add_json(ws, csvData, {
      header: arr,
      skipHeader: true,
      origin: -1
    });
    const wb = { Sheets: { data: ws }, SheetNames: ["data"] };
    const excelBuffer = XLSX.write(wb, { bookType: "xlsx", type: "array" });
    const data = new Blob([excelBuffer], { type: fileType });
    FileSaver.saveAs(data, fileName + fileExtension);
  };

  return (
    <div>
      <button
        variant="warning"
        id="exporttable" className="btn btn-primary"
        onClick={e => exportToCSV(csvData, fileName, null)}
      >
        엑셀추출
      </button>
    </div>
  );
};

export default ExportCSV;

