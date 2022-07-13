import React, { useEffect, useMemo, useState } from "react"

import { ReportuseQueryRequest } from "../../core/ReportQueryRequestProviderReport"
import { ReportSelectuseQueryResponseData } from "../../core/ReportQueryResponseProvider"
import { ReportinitialQueryState } from '../../core/helpers/Reportmodels';
import { ReportListView } from "../../core/ReportListProvider";
import ExportCSV from "../../../../../../project/components/csv/ExportCsv";
import axios from "axios";
import { AllDownLoadButton, DownLoadButton } from "../../../../../../project/components/downloads/Downloads";
const ReportListExcel = () => {
    const selects = ReportSelectuseQueryResponseData()
    const data = useMemo(() => selects, [selects])
    const [option, setOption] = useState('')
    const [excel, setExcel] = useState('')
    const [title, setTtile] = useState('')
    const { setCid, clearSelected } = ReportListView('')
    const { updateState } = ReportuseQueryRequest()
    const REPORT_URL = 'https://online.seoulwomen.or.kr/wp-content/plugins/essays/api/essays.php'

    const getExcel = (post) => {
        const data = []

        for (let i = 0; i < post.length; i++) {
            let obj = {}
            obj['이름'] = post[i]['이름']
            obj['강의명'] = post[i]['강의명']
            obj['레슨명'] = post[i]['레슨명']
            obj['퀴즈명'] = post[i]['퀴즈명']
            obj['질문'] = post[i]['질문']
            obj['제출내용'] = post[i]['제출내용']
            obj['포인트'] = post[i]['포인트']
            obj['상태'] = post[i]['상태']
            obj['제출날짜'] = post[i]['제출날짜']

            data[i] = obj
        }
        setExcel(data)
    }


    useEffect(() => {
        let isComponentMounted = true
        updateState({ cid: option, ...ReportinitialQueryState })
        setCid(option)
        clearSelected()

        const selected = document.querySelector('#selected')
        setTtile(selected.options[selected.selectedIndex].textContent)
        const fetchData = async () => {
            const excelData = await axios.get(`${REPORT_URL}?cid=${option}`)

            if (isComponentMounted) {
                getExcel(excelData.data.data)
            }
        }

        fetchData()
        return () => {
            isComponentMounted = false
        }

    }, [option])

    return (
        <div className="flex justify-content-end">
            <div>
                <select id="selected" onChange={(e) => setOption(e.target.value)} className="form-select form-select-solid" data-control="select2" data-placeholder="Seller Annual Fee" data-hide-search="true">
                    <option value="">강의를 선택 해주세요</option>
                    {data.map((value, key) => {
                        return (
                            <option key={key} value={value.ID}>{value.post_title}</option>
                        )
                    })}
                </select>
            </div>

            {/* <ExportCSV csvData={excel} fileName={title} /> */}
                <DownLoadButton />
                <AllDownLoadButton />
        </div>
    )
}

export default ReportListExcel 

//파일제목 설정
// 검색문제