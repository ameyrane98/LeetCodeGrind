function canFinish(numCourses: number, prerequisites: number[][]): boolean {
    const adj = Array.from({length: numCourses}, ()=>[])
    let visited: number[] = Array.from({length:numCourses},()=>0);
// visited = 2, visiting= 1, unviistei =0;

    console.log(visited); 

    for(let [course, prereq] of prerequisites){
        adj[prereq].push(course);
    }   

    for(let i =0; i<numCourses; i++){
        if(dfs(adj,i,visited)){
            return false;
        }
    }

    return true;
};

function dfs(adj: number[][],i: number, visited:number[] ): boolean {
// If node is in current path → cycle
    if (visited[i] === 1) return true;

    // If already processed → no cycle
    if (visited[i] === 2) return false;

    // Mark as visiting
    visited[i] = 1;

    // Explore neighbors
    for (let neighbor of adj[i]) {
        if (dfs(adj, neighbor, visited)) {
            return true;
        }
    }

    // Mark as done
    visited[i] = 2;

    return false;
   
}