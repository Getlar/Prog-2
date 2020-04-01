using System;

namespace lottozas
{
    class Program
    {
        static void Main(string[] args)
        {
            int min = 90;
            int max = 0;
            string input;
            while ((input = Console.ReadLine()) != null && input != "")
            {
                string[] data = input.Split(' ');
                for(int i = 1; i < data.Length; i++)
                {
                    if(Convert.ToInt32(data[i]) < min)
                    {
                        min = Convert.ToInt32(data[i]);
                    }
                    if(Convert.ToInt32(data[i]) > max)
                    {
                        max = Convert.ToInt32(data[i]);
                    }
                }
            }
            Console.WriteLine(min + " " + max);
        }
    }
}
