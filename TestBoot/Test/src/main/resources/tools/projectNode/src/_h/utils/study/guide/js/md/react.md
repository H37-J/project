## React

이런 함수형 업데이트는 주로 최적화를 위해 사용한다.
```javascript
const counter = () => {
    const [number, setNumber] = useState(0)

    const increase = (prev) => {
        return prev + 1
    }

    const decrease = (prev) => {
        return prev - 1
    }
}
```


## Context
프로젝트 전역에서 사용할 값을 Context에서 관리하면 편하다. 여러 컴포넌트에서 props나 state를 전달 할 필요가 없기 때문이다.

``` javascript
const Dispatch = React.createContext(null);


```