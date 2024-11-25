using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Basics.DataStructures
{
    public class KClosestToX
    {
        public int[] GetKClosestToX(int[]arr, int k, int x) {
            List<KeyValuePair<int,int>> keyValuePairs = new List<KeyValuePair<int,int>>();
            foreach(int i in arr)
                keyValuePairs.Add(new KeyValuePair<int,int>(i,Math.Abs(x-i)));
            return keyValuePairs.OrderBy(item => item.Value).ThenBy(item => item.Key).Select(item => item.Key).ToArray()[0..k];
            
        
        }
    }
}
