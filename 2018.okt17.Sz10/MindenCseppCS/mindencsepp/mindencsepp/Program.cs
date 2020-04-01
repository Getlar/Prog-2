using System;

namespace mindencsepp
{
    class Program
    {
        static void Main(string[] args)
        {
            int uthossz, benzin, hanyszor, fogyasztas, maradek;
            var be = Console.ReadLine();
            var data = be.Split(' ');
            uthossz = Convert.ToInt32(data[0]);
            benzin = Convert.ToInt32(data[1]);
            hanyszor = Convert.ToInt32(data[2]);
            fogyasztas = Convert.ToInt32(data[3]);
            maradek = benzin - uthossz * fogyasztas;
            for (int i = 0; i < hanyszor; i++)
            {
                be = Console.ReadLine();
                var data2 = be.Split(' ');
                maradek = maradek + Convert.ToInt32(data2[1]);
            }
            Console.WriteLine(maradek);
        }
    }
}
