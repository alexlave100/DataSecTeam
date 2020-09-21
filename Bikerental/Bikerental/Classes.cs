using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Bikerental
{
    class Bike
    {
        public Bike()
        {

        }
        public Point position;
        public bool free;
        public int num;
    }  
    class Truck
    {
        public Truck()
        {
            bikes = new List<int>();
        }
        public Point startPosition;
        public Point endPosition;
        public int noBikes;
        public List<int> bikes;
        public void PickupBike(int b)
        {
            bikes.Add(b);
        }
        public void DropBike(int b)
        {
            int foundbike = bikes.Find(bi => bi == b);
            bikes.Remove(foundbike);
        }
    }
    class Request
    {
        public Request()
        {

        }
        public int startTime;
        public int maxWalk;
        public Point startPosition;
        public Point endPosition;
        public Point pickupPosition;
        public Bike bike;


    }
}
