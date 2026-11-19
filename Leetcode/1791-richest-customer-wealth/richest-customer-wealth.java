class Solution {
    public int maximumWealth(int[][] accounts) {
       
        int iMaxWealth = 0;

        for(int i =0;i<accounts.length;i++)
        {
            int iSum = 0;
            for(int z = 0;z<accounts[i].length;z++)
            {
                iSum +=accounts[i][z];
            }
            if(iMaxWealth<iSum)
            {
                iMaxWealth = iSum;
            }
        }
        return iMaxWealth;
    }
}