using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Basics.DataStructures
{
    public class KthLargestElement
    {
        public int GetKthLargestElement(int[] arr, int k) {
            var arrFiltered = arr.OrderDescending().ToArray();
            if (k>arrFiltered.Count())
                return arrFiltered[^1];
            return arrFiltered.Skip(k-1).First();
        }
        public int GetKthDistinctLargestElement(int[] arr, int k)
        {
            var arrFiltered = arr.Distinct().OrderDescending().ToArray();
            if (k>arrFiltered.Count())
                return arrFiltered[^1];
            return arrFiltered.Skip(k-1).First();
        }
    }
}
