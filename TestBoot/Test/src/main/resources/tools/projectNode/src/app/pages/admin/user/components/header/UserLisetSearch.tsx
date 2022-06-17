import { useEffect, useState } from "react"
import { HSVG } from "../../../../../../_h/helpers/components/HSVG"
import { useDebounce } from "../../core/helpers/helpers"
import { initialQueryState } from "../../core/helpers/models"
import { useQueryRequest } from "../../core/QueryRequestProvider"

const UserListSearch = () => {
    const {updateState} = useQueryRequest()
    const [searchString, setSearchString] = useState<string>('')
    const debounceSearchString = useDebounce(searchString, 150)

    useEffect(() => {
        if(debounceSearchString !== undefined && searchString !== undefined) {
            updateState({search: debounceSearchString, ...initialQueryState})
        }
    }, [debounceSearchString])

    return (
        <div className="flex align-items-center position-relative my-1">
            <span className="svg-icon svg-icon-1 position-absolute ms-6">
                <HSVG path="/media/icons/search.svg" />
            </span>
            <input type="text" data-h-user-table-filter="search" className="form-control form-control-solid w-250px ps-14" placeholder="이름을 입력하세요" 
            value={searchString} onChange={(e) => setSearchString(e.target.value)}
            />
        </div>
    )
}

export {UserListSearch}