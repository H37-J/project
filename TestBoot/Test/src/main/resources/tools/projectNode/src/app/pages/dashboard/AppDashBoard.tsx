import { Statics } from "./components/Statics"
import { HardWareInfo } from "./components/HardWareInfo"
import { Logs } from "./components/Logs"

const AppDashBoard = () => {
    return (
        <>
            <Statics />
            <HardWareInfo />
            <Logs />
        </>
    )
}

export { AppDashBoard }