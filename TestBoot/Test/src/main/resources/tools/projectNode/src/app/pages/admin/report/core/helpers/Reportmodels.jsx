export const ReportinitialQueryState = {
  page: 1,
  items_per_page: 100,
}

export const ReportinitialQueryRequest = {
  state: ReportinitialQueryState,
  updateState: () => {},
}

export const ReportinitialQueryResponse = {refetch: () => {}, isLoading: false, query: ''}

export const ReportinitialListView = {
  selected: [],
  onSelect: () => {},
  onSelectAll: () => {},
  clearSelected: () => {},
  setItemIdForUpdate: () => {},
  isAllSelected: false,
  disabled: false,
}
