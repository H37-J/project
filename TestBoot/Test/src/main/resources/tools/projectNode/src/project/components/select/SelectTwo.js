import React, { useEffect, useState } from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import axios from 'axios';

export default function SelectTwo() {
  const [age, setAge] = useState('');
  const [loading, setLoading] = useState(true);
  const [select, setSelect] = useState([]);

  const SELECT_API = `https://kua.bigdeo.com/api_select_course.php`;

  useEffect(() => {
    let Mounted = true;
    const fetchData = async () => {
      const select = await axios.get(SELECT_API);
      if (Mounted) {
        setSelect(select.data);
        setLoading(false);
      }
    };
    fetchData();
    return () => {
      Mounted = false;
    };
  }, []);

  const handleChange = (event) => {
    setAge(event.target.value);
  };

  return (
    <FormControl sx={{ m: 1, minWidth: 150 }} size="small">
      <InputLabel id="select-small">강의를 선택 해주세요</InputLabel>
      <Select
        labelId="select-small"
        id="select-small"
        value={age}
        label="Age"
        onChange={handleChange}
      >
      {!loading && select.map((s) => {
          return ( 
            <MenuItem key={s.ID} value={s.ID}>{s.post_title}</MenuItem>
          )
      })}
      {loading &&  <MenuItem>로딩중..</MenuItem>  }
      </Select>
   
    </FormControl>
  );
}