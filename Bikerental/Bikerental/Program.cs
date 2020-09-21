using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Drawing;

namespace Bikerental
{
    class Program
    {

        static List<Bike> bikes;
        static List<Truck> trucks;
        static List<Request> requests;
        static int basePrice;
        static int actualTime;
        static int noRequests;
        static int noBikes;
        static int noTrucks;
        static void Main(string[] args)
        {
            actualTime = 0;
            Init(args[0]);
            SetStart();
            trucks.First().PickupBike(1);
            trucks.First().PickupBike(2);
            trucks.First().DropBike(1);
        }

        static void SetStart()
        {
            Bike b = new Bike()
            {
                num = 1,
                position = new Point(0, 3),
                free = true
            };
            bikes.Add(b);
            b = new Bike()
            {
                num = 2,
                position = new Point(10, 4),
                free = true
            };
            bikes.Add(b);
        }
        static void Init(string inputfile)
        {
            StreamReader sr = File.OpenText(inputfile);
            // read first line for Properties.
            string[] props = sr.ReadLine().Split(new char[] { ' ' });
            // create requests array
            noRequests = int.Parse(props[0]);
            requests = new List<Request>();
            // create bikes array
            noBikes = int.Parse(props[1]);
            bikes = new List<Bike>();            
            // create trucks array
            noTrucks = int.Parse(props[2]);
            trucks = new List<Truck>();
            for (int i = 0; i < noTrucks; i++)
            {
                Truck truck = new Truck();
                truck.noBikes = int.Parse(props[3]);
                trucks.Add(truck);
            }
            // read base price for rentals
            basePrice = int.Parse(props[4]);
            // iterate over requests and create them in the requests array
            string line;
            while ((line = sr.ReadLine()) != null)
            {
                string[] linearr = line.Split(new char[] { ' ' });
                requests.Add(new Request()
                {
                    startTime = int.Parse(linearr[0]),
                    startPosition = new Point(int.Parse(linearr[1]), int.Parse(linearr[2])),
                    endPosition = new Point(int.Parse(linearr[3]), int.Parse(linearr[4])),
                    maxWalk = int.Parse(linearr[5])
                });
            }
            // close streamreader and trash it.
            sr.Close();
            sr = null;
        }
    }
}
