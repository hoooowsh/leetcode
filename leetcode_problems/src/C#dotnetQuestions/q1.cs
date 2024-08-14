using System;

public class MegaStore
{
    public enum DiscountType
    {
        Standard,
        Seasonal,
        Weight
    }

    public static double GetDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType)
    {
        double finalPrice = 0;
        if (discountType == DiscountType.Standard || (discountType == DiscountType.Weight && cartWeight <= 10))
        {
            finalPrice = totalPrice * (1 - 0.06);
        }
        if (discountType == DiscountType.Seasonal)
        {
            finalPrice = totalPrice * (1 - 0.12);
        }
        if (discountType == DiscountType.Weight && cartWeight > 10)
        {
            finalPrice = totalPrice * (1 - 0.18);
        }
        return finalPrice;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(GetDiscountedPrice(12, 100, DiscountType.Weight));
    }
}