/**
 * @(#)NamsNimAI.java
 *
 *
 * @author 
 * @version 1.00 2014/9/29
 */


public class AI {
	
    public int[] move(int[] p){
	int lllllll[] = new int[4];
	for(int l = 0; l < 4; l++)lllllll[l] = p[l];
	while(lllllll[0]>lllllll[1] || lllllll[1] > lllllll[2] || lllllll[2] > lllllll[3]){
	for(int l = 0; l < 3; l++){
	if(lllllll[l]>lllllll[l+1]){
	int ll = lllllll[l+1];lllllll[l+1] = lllllll[l];lllllll[l] = ll;}}}
	int[] l1l = new int[2];
	int[][] llllll = {
	{0,0,0,1,0,1,0,2,0,1,0,1,1,2,2},{0,1,1,1,3,1,1,0,0,1,3,0,2,1,3},{0,0,2,2,0,1,1,0,0,1,2,3,0,1,2},{1,1,2,2,3,1,1,0,0,1,2,3,0,3,0},{2,2,2,2,3,0,1,0,0,1,2,0,3,0,4},{0,0,3,3,3,1,1,0,0,1,2,3,0,0,2},
	{1,1,3,3,3,1,1,0,0,1,2,3,0,0,1},{2,2,3,3,3,1,1,0,0,0,3,2,0,0,1},{3,3,3,3,3,1,1,0,0,2,2,2,3,3,2},{0,1,2,3,3,1,1,0,0,1,1,2,2,2,1},{1,2,3,4,3,1,1,0,0,0,2,0,2,0,0},{0,2,2,4,3,1,1,0,0,1,1,0,1,0,0},
	 {0,3,3,4,3,1,1,0,0,0,3,4,0,2,3},{0,0,1,4,3,1,1,0,0,4,2,0,1,0,4},{1,1,1,4,3,1,1,0,0,2,3,0,0,4,3},{0,1,4,4,3,1,1,0,0,3,0,3,0,2,2},{1,4,4,4,3,1,1,0,0,1,1,1,2,3,2}};
	for(int lllll = 0; lllll < 4; lllll++){for(int llll = 1; llll < 4; llll++){boolean l111 = true;int[] l1ll1 = new int[4];
	for(int l = 0; l < 4; l++){l1ll1[l] = lllllll[l];}l1ll1[lllll] -= llll;while(l1ll1[0]>l1ll1[1] || l1ll1[1] > l1ll1[2] || l1ll1[2] > l1ll1[3]){
	for(int l = 0; l < 3; l++){if(l1ll1[l]>l1ll1[l+1]){int t = l1ll1[l+1];l1ll1[l+1] = l1ll1[l];l1ll1[l] = t;}}}
	if(l1ll1[lllll] >= 0){for(int l1l1l = 0; l1l1l < llllll.length; l1l1l++){l111 = true;
	for(int pil = 0; pil < 4; pil++){if(l1ll1[pil] != llllll[l1l1l][pil]){l111 = false;}}if(l111){l1l[0] = llll;l1l[1] = lllllll[lllll];
	return l1l;}}}}}for(int l = 0; l < 4; l++){if(lllllll[l] > 0){l1l[0] = 1;l1l[1] = lllllll[l];break;}}return l1l;}
}