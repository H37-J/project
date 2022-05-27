import React, { useState, useEffect } from 'react';
import { getUser } from '../../api/project/project.js';
import { ProjectUserModel } from '../model/_projectModel';

const ProjectUser: React.FC = () => {
  const [users, setUsers] = useState<ProjectUserModel[]>([]);
  useEffect(() => {
    getUser().then((res) => {
      setUsers(res.data);
    });
  }, []);

  return (
    <div>
      {users.map((user) => {
        return <div key={user.ID}>{user.user_login}</div>;
      })}
    </div>
  );
};

export { ProjectUser };
