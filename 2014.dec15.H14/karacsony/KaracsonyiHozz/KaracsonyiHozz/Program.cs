using System;
using System.Collections.Generic;
using System.Linq;

namespace KaracsonyiHozz
{
    class Program
    {
        static void Main(string[] args)
        {
            IDictionary<String, int> dict = new SortedDictionary<String, int>();
            string line;
            while((line = Console.ReadLine()) != null)
            {
                string[] be = line.Split(';');
                int sum = 0;
                bool isvalue = dict.TryGetValue(be[0], out sum);
                if (isvalue == false)
                {
                    dict.Add(be[0], sum);
                }
                dict[be[0]] += int.Parse(be[1]);
            }
            var sortedDict = from entry in dict orderby entry.Value descending, entry.Key ascending select entry;
            foreach (var entry in sortedDict)
            {
                Console.WriteLine(entry.Key + ";" + entry.Value);
            }
        }
    }
}
