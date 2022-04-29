import React, { useState } from 'react';

const Listadd = () => {
    const [names, setNames] = useState([
        {id: 1, text: 'test1'},
        {id: 2, text: 'test2'},
    ]);
    const [inputText, setInputText] = useState('');
    const [nextId, setNextId] = useState(5);

    const onChange = e => setInputText(e.target.value);

    const onClick = () => {
        const nextNames = name.concat({
            id: nextId,
            text: inputText
        });
        setNextId(nextId + 1);
        setNames(nextNames);
        setInputText('');
    };

    const onRemove = id => {
        const nextNames = names.filter(name => name.id !== id);
        setNames(nextNaems);
    }

    const nameList = names.map(name => <li key={name.id} onDoubleClick={onRemove(name.id)}>{name.text}</li>)
    return(
        <div>
            <input value={inputText} onChange={onChange} />
            <button onClick={onClick}>cnrk</button>
            <ul>{nameList}</ul>
        </div>
    )
};

