import { FC, PropsWithChildren, useMemo } from "react"
import { HeaderProps } from "react-table"
import { User } from "../../core/UserModel"

import { useQueryRequest } from "../../core/QueryRequestProvider";
import { initialQueryState } from '../../core/helpers/models';
import clsx from "clsx";

type Props = {
    className?: string
    title?: string
    tableProps: PropsWithChildren<HeaderProps<User>>
}

const UserCustomHeader: FC<Props> = ({ className, title, tableProps }) => {
    const id = tableProps.column.id
    const { state, updateState } = useQueryRequest()

    const isSelectedForSorting = useMemo(() => {
        return state.sort && state.sort === id
    }, [state, id])
    const order: 'asc' | 'desc' | undefined = useMemo(() => state.order, [state])

    const sortColumn = () => {
        if (id === 'actions' || id === 'selection') {
          return
        }
    
        if (!isSelectedForSorting) {
          updateState({sort: id, order: 'asc', ...initialQueryState})
          return
        }
    
        if (isSelectedForSorting && order !== undefined) {
          if (order === 'asc') {
            updateState({sort: id, order: 'desc', ...initialQueryState})
            return
          }
    
          updateState({sort: undefined, order: undefined, ...initialQueryState})
        }
      }

      return (
          <th 
          {...tableProps.column.getHeaderProps()}
          className={clsx(
              className,
              isSelectedForSorting && order !== undefined && `table-sort-${order}`
          )}
          style={{cursor: 'pointer'}}
          onClick={sortColumn}>
              {title}
          </th>
      )
}

export {UserCustomHeader}