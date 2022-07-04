// 주석처리 한 것은 해결
//프로그래머스 K번째 수
// function solution(array, commands) {
//     const res = []
//     const length = commands.length
//     for(let i = 0; i < length; i++) {
//         const start = commands[i][0] - 1
//         const end = commands[i][1]
//         const pick = commands[i][2] - 1
//         const answer = array.slice(start, end).sort((a, b) => a - b)[pick]
//         res.push(answer)
//     }
//     return res
// }

//완주하지 못한 선수
function solution(participant, completion) {
    const sc = new Set(completion)
    const answer = participant.some(p => sc.has(p)) 
    return answer;
}
const participant = ["leo", "kiki", "eden"]
const completion = ["eden", "kiki"]
const result = solution(participant, completion)
