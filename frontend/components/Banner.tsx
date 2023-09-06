"use client";

import React from 'react'
import Image from 'next/image';
import Carousel from 'better-react-carousel'

import { BannerProps } from '@types';
import Link from 'next/link';

const Banner = ({content}: BannerProps) => {
  return (
    <div className='min-h-[550px] flex-1 flex-row flex justify-center items-center'>
      <div className='flex-1 flex-row flex justify-center items-center pt-36 sm:px-16 px-6 max-w-[1440px]'>
        <Carousel
          autoplay={4000}
          cols={1}
          gap={10}
          loop
          rows={1}
          scrollSnap
          showDots
        >
          {content.map((element, index) => {
            return (
              <Carousel.Item key={element.id}>
                <Link
                  href={`/content/${element.id}`}
                >
                  <Image className='cursor-pointer'
                    alt={`Imagem banner ${index + 1}`}
                    height={550}
                    src={element.link}
                    width={1440}
                  />
                </Link>
              </Carousel.Item>
            )
          })}
        </Carousel>
      </div>
    </div>
  )
}

export default Banner;