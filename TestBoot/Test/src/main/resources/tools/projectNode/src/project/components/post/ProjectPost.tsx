import React, { useState, useEffect } from 'react';
import { getPost, getUser } from '../../api/project/project.js';
import { ProjectPostModel } from '../model/_projectModel';

const ProjectPost: React.FC = () => {
  const [posts, setPosts] = useState<ProjectPostModel[]>([]);
  useEffect(() => {
    getPost().then((res) => {
      setPosts(res.data);
    });
  }, []);

  return (
    <div>
      {posts.map((post) => {
        return <div key={post.ID}>{post.post_title}</div>;
      })}
    </div>
  );
};

export { ProjectPost };
