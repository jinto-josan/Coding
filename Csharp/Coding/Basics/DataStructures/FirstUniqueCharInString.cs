using System.Collections.Specialized;
using System.Linq;

namespace Basics.String
{
    public class FirstUniqueCharInString
    {
        public char GetFirstUniqueCharInString(string str) {

            Dictionary<char,int> dict = new Dictionary<char, int>();
            foreach (char c in str)
            {
                
                if (dict.ContainsKey(c))
                    dict[c]+=+1;
                else
                    dict.Add(c, 1);
            }
            foreach(var k in str)
            {
                if ( dict[k]==1)
                    return k;
            }
            return (char)0;

        }

    }
}
