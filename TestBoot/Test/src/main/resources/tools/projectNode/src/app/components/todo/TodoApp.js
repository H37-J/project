


const TodoApp = () => {
    const createBulkTodos= () => {
        const array = [];
        for(let i = 1; i <= 2500; i++) {
            array.push({
                id: i,
                text: `할 일 ${i}`,
                checked: false,
            });
        }
        return array;
    }

    const nextId = useRef(2501);

    const [todos, dispatch]  = useReducer(TodoReducer, undefined, createBulkTodos);

    const onInsert = useCallback(text => {
        const todo = {
            id: nextId.current,
            text,
            checked: false
        };
        dispatch({type: 'INSERT', todo});
        nextId.current += 1;
    }, []);

    const onRemove = useCallback(id => {
        dispatch({type: 'REMOVE', id});
    }, []);

    const onToggle = useCallback(id => {
        dispatch({type: "TOGGLE", id});
    }, []);
   

    return (
        <TodoTemplate>
            <TodoInsert onInsert={onInsert} />
            <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
        </TodoTemplate>
    );
};

export default TodoApp;