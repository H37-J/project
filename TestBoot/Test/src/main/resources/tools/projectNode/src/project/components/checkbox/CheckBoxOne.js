import * as React from 'react';
import Checkbox from '@mui/material/Checkbox';

const CheckBoxOne = ({checkHandle}) => {
  const [checked, setChecked] = React.useState(true);

  const handleChange = (event) => {
    setChecked(event.target.checked);
    checkHandle()
  };

  return (
    <Checkbox
      checked={checked}
      onChange={handleChange}
      inputProps={{ 'aria-label': 'controlled' }}
    />
  );
}

export default CheckBoxOne;