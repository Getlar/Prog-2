using System;
using System.Collections.Generic;

namespace Tartozasok
{
    class Program
    {
        static void Main(string[] args)
        {
            IDictionary<string, IDictionary<string, int>> dict = new SortedDictionary<string, IDictionary<string, int>>();

            string row;
            while ((row = Console.ReadLine()) != null)
            {
                string[] datas = row.Split(';');
                for (int i = 2; i < datas.Length; i++)
                {
                    IDictionary<string, int> value;
                    bool isvalue = dict.TryGetValue(datas[i], out value);
                    if (isvalue == false)
                    {
                        value = new SortedDictionary<string, int>();
                        dict.Add(datas[i], value);
                    }
                    int sum = 0;
                    bool issum = value.TryGetValue(datas[0], out sum);
                    if (issum == false)
                    {
                        value.Add(datas[0], sum);
                    }
                    value[datas[0]] += int.Parse(datas[1]);
                }
            }
            foreach (var entry in dict)
            {
                foreach (var foo in entry.Value)
                {
                    Console.WriteLine(entry.Key + " => " + foo.Key + ": " + foo.Value);
                }
            }
        }
    }
}
