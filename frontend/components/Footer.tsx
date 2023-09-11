import Image from "next/image"

const Footer = () => {
  return (
    <footer className="flex flex-col text-black-100 mt-5 border-t border-gray-100 bg-slate-100">
      <div className="flex max-md:flex-col flex-wrap justify-between gap-5 sm:px-16 px-6 py-10">
        <div className="flex flex-col justify-start items-start gap-6">
          <Image className="object-contain"
            alt="Logo"
            height={18}
            src={"/logo.png"}
            width={118}
          />
          <p className="text-base text-gray-700 text-center flex">
            &copy; Copyright Mira 2023
          </p>
        </div>
      </div>
    </footer>
  )
}

export default Footer